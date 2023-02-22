def buildStatus    = "FAILED"   //2 secenek var pass yada fail bunu empty birakamam fail koyduk
def slackColor     = "warning"  // bu bir renk green ve orange var jenkinde .. green gecti orange gecmedi
def slackChannelID = 'C03NE82PLMQ' //burda channel id yaziyoruz slackde channel id gorursun onu yazdik

pipeline {
  agent any
  tools {                               //which tool you wanna use
    maven 'Maven 3.3.9'              // burda toolslari yazdik bagladik hangi tools need onu koyduk
    jdk 'jdk8'
  }
  triggers{                            //how often you wanna run
    cron 'H 2,16 * * *'              //saat 4 pm gibi birset di
  }
  stages {                          //which script do you wanna run
    stage('Run Tests') {
      steps {
      //  sh  'echo started'  bunlari koyarak test yapinca hani belli eder nerde yanlis var mesela mvn testte
        sh 'mvn clean'
        sh 'mvn test'
       // sh  ' echo ended'
      }
    }
  }
  post{                         //do you need report ?
    always{
      junit '**/surefire-reports/*.xml'    // buda bize cucumber report vericek jenkinimizde
      cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: 'target/cucumber.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }
    success { // jenkin succes olursa yukardaki buil status failed yazisi pass olcak succes olcak
      script {
        buildStatus = "SUCCESS"
        slackColor = "good"
      }
    }
    cleanup {
      script {
        slackSend channel: slackChannelID, color: "${slackColor}", message: "*${buildStatus}*: `${env.JOB_NAME}` *#${env.BUILD_NUMBER}* \n<${env.BUILD_URL}/console|Console Log>"
      } // hangi channel (yukarda belli ) , rengi , hangi mesaji yollucaz
    }
  }
}
// bunu kullanmadan once configradition chromeheadline yazmayi unutma yoksa hata alirsin