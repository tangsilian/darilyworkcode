# Script to start "am" on the device, which has a very rudimentary
# shell.
#
base=/system
export CLASSPATH=$base/framework/testandroid.jar
exec app_process $base/bin com.jaytang.linux.Main "$@"