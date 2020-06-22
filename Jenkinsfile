pipeline {
  agent any
  stages {
    stage('构建') {
      steps {
        sh './gradlew build'
      }
    }

    stage('打包到制品库') {
      steps {
        archiveArtifacts 'build/libs/**'
      }
    }
    stage('部署') {
      steps {
          echo '开始部署'
          try{
            sh '''
            screen -X -S ivory-backend quit
            '''
          }
          sh '''
          screen -S ivory-backend
          '''
          echo '部署结束'
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