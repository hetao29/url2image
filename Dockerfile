#https://hub.docker.com/r/alekzonder/puppeteer/dockerfile
FROM alekzonder/puppeteer:1.20.0

# Set language to UTF8
ENV LANG="C.UTF-8"

USER root

RUN sed -i 's/deb.debian.org/mirrors.163.com/g' /etc/apt/sources.list \ 
	&& apt-get update \
	&& apt-get install -yq xfonts-utils procps

WORKDIR /data/urltoimage

# Add user so we don't need --no-sandbox.
RUN mkdir -p /data/screenshots \
	&& mkdir /data/urltoimage/etc/ \
	&& mkdir /usr/share/fonts/truetype/custom \
	&& mkdir /data/urltoimage/bin/ \
	&& chown -R pptruser:pptruser /data/screenshots \
	&& chown -R pptruser:pptruser /data/urltoimage

COPY fonts/* /usr/share/fonts/truetype/custom/

RUN mkfontscale \
	&& mkfontdir \
	&& fc-cache -f -v \
	&& npm install grpc @grpc/proto-loader

COPY proto_src ./proto_src
COPY conf.js ./
COPY server.js ./

#HEALTHCHECK --interval=5s --timeout=5s --retries=3 \
#    CMD ps aux | grep "urltoimage" | grep -v "grep" > /dev/null; if [ 0 != $? ]; then exit 1; fi

EXPOSE 80/tcp
# Run everything after as non-privileged user.
# USER pptruser

# --cap-add=SYS_ADMIN
# https://docs.docker.com/engine/reference/run/#additional-groups

# ENTRYPOINT ["dumb-init", "--"]

#CMD ["/data/urltoimage/bin/server"]
CMD ["/data/urltoimage/server.js"]
