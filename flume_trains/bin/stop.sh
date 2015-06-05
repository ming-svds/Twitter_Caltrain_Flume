#!/bin/bash

echo "Stopping trains data collection...";

export JAVA_HOME="/usr/lib/jvm/default-java";

export FLUME_TRAINS_HOME="$(cd $(dirname $0)/.. && pwd)";

export FLUME_TRAINS_LOG_HOME="$FLUME_TRAINS_HOME/logs";
mkdir -p $FLUME_TRAINS_LOG_HOME

echo "JAVA_HOME is $JAVA_HOME!";
echo "FLUME_TRAINS_HOME is $FLUME_TRAINS_HOME!";
echo "FLUME_TRAINS_LOG_HOME is $FLUME_TRAINS_LOG_HOME!";

$FLUME_TRAINS_HOME/agent/bin/jsw.sh stop

exit 0;
