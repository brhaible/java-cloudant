#!/bin/sh
if test $# != 0; then
  echo "Usage: recompile.sh" 1>&2
  exit 1
fi
MAVEN_REPOSITORY=${HOME}/.m2/repository
stamp=`date +%Y%m%d%H%M`
version=1.0.1-wl-${stamp}
sourcedir_absolute=`pwd`
sourcedir=`basename "${sourcedir_absolute}"`
rm -f ../cloudant-client.jar
rm -rf ../${sourcedir}-bin &&
mkdir ../${sourcedir}-bin &&
git checkout mfp &&
commithash=`git log --format=format:%H -1` &&
(cd src/main/java && javac -g -source 1.5 -target 1.5 -d ../../../../${sourcedir}-bin -classpath ${MAVEN_REPOSITORY}/com/google/code/gson/gson/2.3.1/gson-2.3.1.jar:${MAVEN_REPOSITORY}/org/apache/httpcomponents/httpclient-osgi/4.3.4/httpclient-osgi-4.3.4.jar:${MAVEN_REPOSITORY}/org/apache/httpcomponents/httpcore-osgi/4.3.2/httpcore-osgi-4.3.2.jar:${MAVEN_REPOSITORY}/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar `find . -name '*.java'`) &&
(cd ../${sourcedir}-bin && jar cf ../cloudant-client-${version}.jar *) &&
(cd src/main/java && jar cf ../../../../cloudant-client-${version}-sources.jar *) &&
sed -e "s/VERSION/${version}/g" -e "s/COMMITHASH/${commithash}/g" < cloudant-client.pom.template > ../cloudant-client-${version}.pom &&
ln -sf cloudant-client-${version}.jar ../cloudant-client.jar &&
ln -sf cloudant-client-${version}-sources.jar ../cloudant-client-sources.jar &&
ln -sf cloudant-client-${version}.pom ../cloudant-client.pom
