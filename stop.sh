#!/bin/bash

docker ps | grep shuaicj | awk '{print $1}' | xargs docker stop
