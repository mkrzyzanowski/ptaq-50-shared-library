def call(Map config) {
    withMaven(maven: 'maven') {
        sh "mvn clean test -Dwebdriver.type=remote -Dwebdriver.url=${config.gridUrl} -Dwebdriver.cap.browserName=${config.browser}"
    }
    junit testResults: 'target/surefire-reports/*.xml'
    archiveArtifacts 'target/**'
}
