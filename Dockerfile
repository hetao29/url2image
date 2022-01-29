FROM alpine:3.15

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories \
	&& apk update \
	&& apk add tzdata  \
	&& ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
	&& echo "Asia/Shanghai" > /etc/timezone

RUN apk add --no-cache \
      chromium \
      nss \
      freetype \
      harfbuzz \
      ca-certificates \
      ttf-freefont \
	  terminus-font ttf-inconsolata ttf-dejavu font-noto ttf-font-awesome \
	  font-sony-misc font-daewoo-misc font-jis-misc \
	  font-vollkorn font-misc-cyrillic font-mutt-misc font-screen-cyrillic font-winitzki-cyrillic font-cronyx-cyrillic \
	  font-isas-misc \
	  msttcorefonts-installer \
	  font-adobe-100dpi fontconfig \
      nodejs npm \
	  mkfontscale \
	  font-noto-emoji \
	  procps
RUN apk add wqy-zenhei --update-cache --repository http://nl.alpinelinux.org/alpine/edge/testing/ --allow-untrusted

ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=true \
	PUPPETEER_EXECUTABLE_PATH=/usr/bin/chromium-browser
RUN addgroup -S pptruser && adduser -S -g pptruser pptruser \
    && mkdir -p /home/pptruser/Downloads /app \
    && chown -R pptruser:pptruser /home/pptruser \
    && chown -R pptruser:pptruser /app

# Set language to UTF8
ENV LANG="C.UTF-8"

USER root

WORKDIR /data/urltoimage

# Add user so we don't need --no-sandbox.
RUN mkdir -p /data/screenshots \
	&& mkdir /data/urltoimage/etc/ \
	&& mkdir /usr/share/fonts/truetype/custom \
	&& mkdir /data/urltoimage/bin/ \
	&& chown -R pptruser:pptruser /data/screenshots \
	&& chown -R pptruser:pptruser /data/urltoimage

COPY fonts/* /usr/share/fonts/truetype/custom/

RUN update-ms-fonts && fc-cache -f
RUN mkfontscale \
	&& mkfontdir \
	&& fc-cache -f -v 
RUN npm i puppeteer
RUN npm i @grpc/grpc-js @grpc/proto-loader

COPY proto_src ./proto_src
COPY conf.js ./
COPY server.js ./

HEALTHCHECK --interval=5s --timeout=5s --retries=3 \
    CMD ps aux | grep "urltoimage" | grep -v "grep" > /dev/null; if [ 0 != $? ]; then exit 1; fi

EXPOSE 80/tcp
# Run everything after as non-privileged user.
USER pptruser
CMD ["/data/urltoimage/server.js"]
