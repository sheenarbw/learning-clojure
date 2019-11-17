; doing some excercises from here
; https://clojure.org/guides/learn/functions#_test_your_knowledge

; these are the same

(defn greet [] (println "yo"))
(def greet (fn [] (println "yo")))
(def greet #(println "yo"))
(greet) the same

(defn greet [] (println "yo"))
(def greet (fn [] (println "yo")))
(def greet #(println "yo"))
(greet)

; 3 

(defn greeting
  ([hello name] (str hello ", " name "!"))
  ([name] (greeting  "Hello" name))
  ([] (greeting "World")))

;; For testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

;4 

(defn do-nothing [x] (identity x))
(defn do-nothing [x] x)
(assert (= "Hello, World!" (do-nothing "Hello, World!")))

(source identity)
; 5 

(defn always-thing [& ignore-me] 100)
(assert (= 100 (always-thing)))


; 6 

(defn make-thingy [x] (fn [& ignore-this] x))

;; Tests
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))


(source constantly)

; 7

(defn triplicate [f] (f) (f) (f))

(triplicate greet)


(def temp (fn [] println "yo" println "bob"))
(def temp (fn [] (println "yo") (println "bob")))
(temp)
(triplicate (fn [] (println "winning")))

; 8 



(defn opposite [f]
  (fn [& args] (not (apply f args))))


((opposite (fn [a b c] false)) 1 2 3)


; 9 

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))


(triplicate2
 (fn [s] (println s))
 "yo")


; 9

; The cosine of pi is -1

(assert (= (Math/cos Math/PI) -1.0))

; For some x, sin (x) ^2 + cos (x) ^2 = 1

(defn trig [x] (+ (Math/pow (Math/sin x) 2) (Math/pow (Math/cos x) 2)))

(assert (= (trig 1) 1.0))
(assert (= (trig 2) 1.0))
; (assert (= (trig 3) 1.0 ) (trig 3))

; 10

(defn http-get [url]

  (java.Net.URL. url) ; url object. defined here: https://docs.oracle.com/javase/8/docs/api/java/net/URL.html 
  )

(assert (.contains (http-get "https://www.w3.org") "html"))