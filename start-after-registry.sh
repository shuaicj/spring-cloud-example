#!/bin/sh

seconds=0

while true ; do
    ready="true"

    for host in $@ ; do
        apps=$(curl -f -s http://$host/eureka/apps)
        exit_code=$?

        if [ $exit_code -ne 0 ] ; then
            echo "$host not up"
            ready="false"
            break
        fi

        for h in $@ ; do
            if [ $(echo $apps | grep $h | wc -l) -eq 0 ] ; then
                echo "$h not registered to $host"
                ready="false"
                break 2
            fi
        done
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
