#!/bin/bash

PORT=8888 bash -c 'docker run -d -p $PORT:$PORT -e PORT=$PORT --rm shuaicj/hello-cloud-config'

PORT=8761 bash -c 'docker run -d -p $PORT:$PORT -e PORT=$PORT --rm shuaicj/hello-cloud-netflix-eureka'
