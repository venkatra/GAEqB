JAVA_HOME='/cygdrive/c/Program\ Files/Java/jdk1.6.0_34'
class=com.intuit.developer.QBSyncService
clpth='./war/WEB-INF/classes'
resourcedir='./war'
outsourcedir='./src'
outdir='./war/WEB-INF/classes'

/cygdrive/c/Program\ Files/Java/jdk1.6.0_34/bin/wsgen -cp "$clpth" -wsdl -keep -r "$resourcedir" -d "$outdir" -s "$outsourcedir"  $class