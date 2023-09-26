<?php
// GENERATED CODE -- DO NOT EDIT!

namespace Liburltoimage {

  class UrltoimageClient extends \Grpc\BaseStub {

    /**
     * @param string $hostname hostname
     * @param array $opts channel options
     * @param \Grpc\Channel $channel (optional) re-use channel object
     */
    public function __construct($hostname, $opts, $channel = null) {
      parent::__construct($hostname, $opts, $channel);
    }

    /**
     * Sends a greeting
     * @param \Liburltoimage\Request $argument input argument
     * @param array $metadata metadata
     * @param array $options call options
     */
    public function Convert(\Liburltoimage\Request $argument,
      $metadata = [], $options = []) {
      return $this->_simpleRequest('/liburltoimage.Urltoimage/Convert',
      $argument,
      ['\Liburltoimage\Response', 'decode'],
      $metadata, $options);
    }

  }

}
