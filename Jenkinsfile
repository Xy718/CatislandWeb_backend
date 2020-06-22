pipeline {
  agent any
  stages {
    stage('构建') {
      steps {
        sh './gradlew build'
      }
    }
    stage('部署') {
      def remote = [:]
      remote.name = "ci"
      remote.host = "81.68.74.125"
      remote.allowAnyHosts = true
      steps {
          echo '开始部署'
            writeFile file: 'abc.sh', text: 'ls'
            sshCommand remote: remote, command: 'for i in {1..5}; do echo -n \"Loop \$i \"; date ; sleep 1; done'
            sshPut remote: remote, from: 'abc.sh', into: '.'
            sshGet remote: remote, from: 'abc.sh', into: 'bac.sh', override: true
            sshScript remote: remote, script: 'abc.sh'
            sshRemove remote: remote, path: 'abc.sh'
          echo '部署结束'
      }
    }
    stage('打包到制品库') {
      steps {
        archiveArtifacts 'build/libs/**'
      }
    }
    stage('提示') {
      steps {
        emailext(
          subject: '尊敬的逼大人'
          , body: '$DEFAULT_CONTENT'
          , attachLog: true
          , compressLog: true
          , postsendScript: '$DEFAULT_POSTSEND_SCRIPT'
          , presendScript:'$DEFAULT_PRESEND_SCRIPT'
          ,to: '895487526@qq.com'
        )
        echo 'biki的提示邮件发送完毕'
        emailext(
          subject: 'Xy718'
          , body: '$DEFAULT_CONTENT'
          , attachLog: true
          , compressLog: true
          , postsendScript: '$DEFAULT_POSTSEND_SCRIPT'
          , presendScript:'$DEFAULT_PRESEND_SCRIPT'
          ,to: '869839000@qq.com'
          )
        echo 'Xy718的提示邮件发送完毕'
      }
    }
  }
}