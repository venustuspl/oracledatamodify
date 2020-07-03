echo "Oracle Services starting: "
#obsługę ewentualnych błędów zrobię później

net start "OracleJobSchedulerORCL1"
net start "OracleOraDB12Home2MTSRecoveryService"
net start "OracleOraDB12Home2TNSListener"
net start "OracleServiceORCL1"
net start "OracleVssWriterORCL1"

echo "Oracle services was started."