echo "Oracle services stopping: "

net stop "OracleJobSchedulerORCL1"
net stop "OracleOraDB12Home2MTSRecoveryService"
net stop "OracleOraDB12Home2TNSListener"
net stop "OracleServiceORCL1"
net stop "OracleVssWriterORCL1"

echo "Oracle services was stopped."