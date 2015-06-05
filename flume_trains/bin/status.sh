#!/bin/bash

export JAVA_HOME="/usr/lib/jvm/default-java";

export FLUME_TRAINS_HOME="$(cd $(dirname $0)/.. && pwd)";

export FLUME_TRAINS_LOG_HOME="$FLUME_TRAINS_HOME/logs";
mkdir -p $FLUME_TRAINS_LOG_HOME

$FLUME_TRAINS_HOME/agent/bin/jsw.sh status
exit $?;
