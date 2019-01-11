#!/bin/sh

seconds=0

while true ; do
    ready="true"

    for host in $@ ; do
        apps=$(curl -f -s -H "Accept: application/json" http://$host/eureka/apps/)
        exit_code=$?

        if [ $exit_code -ne 0 ] ; then
            echo "$host not up"
            ready="false"
            break
        fi

        if [ $(echo $apps | grep '"name":"CONFIG"' | wc -l) -eq 0 ] ; then
            echo "config-service not registered to $host"
            ready="false"
            break
        fi
    done

    if [ $ready = "true" ] ; then
        break
    else
        let seconds++
        echo "sleep $seconds"
        sleep 1
    fi
done

./start.sh
