# tentekiHeavy

(https://github.com/vascarpenter/tentekiHeavy/blob/master/tentekiss.jpg)
- kotlinによる tentekiLiteの移植
  - clickで water/energy/NaClを計算してくれる
  - 複数いれるときに別の物をクリックしないと入れられない
  
- 技術的な面
  - swing gui は Javaとして追加している
    - JavaVM 6に対応するためには
      - Project Structure の Project Language Level = 6
      - Prefs > Java Compiler byte code version 6
      - Prefs > Kotlin Compiler Target JVM 1.6
      
  - swing JList の応用
    - kotlin data class を Vectorとして JListに追加している

  - 他は、あまり見るべき物はないね
