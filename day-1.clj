(println "hello") ; I'm a comment

; getting help
; (doc +) ; docs for symbol
; (apropos "+") ; find docs for something with "+" in the name
; (find-doc "trim") ; find docs for something wiht "trim" in the docstring or name 
; (dir clojure.repl)  ; give a list of all the available things
; (source thing); view the source

; useful cheetsheet: https://clojure.org/api/cheatsheet

; declare a variable x, store a value 

(def x "sup") ; evaluates to #'user/x   eh?
(println x)

; get a value from std in
(def foo (read-line))


(println "let's add stuff: \n1 + 2 =" (+ 1 2)) ; for people
(prn "let's add stuff: \n1 + 2 =" (+ 1 2)) ; for machines

; print and pr work similarly

;( 7 + 3 * 4 + 5 ) / 10

(/ (+ 7 (* 3 4) 5) 10)

; now for functions :)
; https://clojure.org/guides/learn/functions

(defn greet  [name]  (str "Hello, " name)) ; returns the string

; use recursion to set default args. Interesting
(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println msg)))


(def inputString (read-line))
(println "Hello, World.")
(println inputString)


(defn greet2
  ([name]    (def fullGreeting (str "Hello, " name))
             (println fullGreeting)
             (str fullGreeting))) ; returns the string



(def booya (greet2 "bob"))


; ok, how do I actually add these up
(defn adder [& numbers]
  (println "adding:" numbers))

(adder 1 2 3)

(defn adder [& numbers]
  (println "adding:" numbers)
  (apply  +  numbers))  ; AHA like this... more on apply later

(adder 1 2 3 4)

; anon funcs wok like this:

((fn  [& messages]  (prn messages)) "hi there" "I was wondering" "if you like" 5)

; usuually used for callbacks rather than immediate invokation




;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

(#(+ 6 %) 4)

;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

(#(+ %1 %2) 1 2)


;; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)

(#(println %1 %2 %&) "a" "b" "c" 1 2 3 4 5)


; apply unpacks the last thing
(apply f '(1 2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 '(2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 '(3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 3 '(4))    ;; same as  (f 1 2 3 4)




(let [x 1
      y 2]
  (+ x y))

; functions that return functions are a thing

(defn messenger-builder [greeting]
  (fn [who] (println greeting who))) ; closes over greeting

(def hello-er (messenger-builder "Sup Yo"))
(hello-er "bob")

((messenger-builder "Sup Yo") "Sally")


((fn [greeting] (fn [who] (println "--" greeting who "--")) "aaa") "bbb") ; returns aaa
(((fn [greeting] (fn [who] (println "--" greeting who "--"))) "aaa") "bbb") ; prints useful things

(def greeting "temp")
((fn [who] (println "--" greeting who "--")) "aaa")

(((fn [greeting] (fn [who] (println greeting who))) "hello") "bob")



((fn [greeting] (fn [who] (println "--" greeting who "--")) "aaa")

 "bbb") ; returns aaa


((fn [greeting] (fn [who] (println "--" greeting who "--")) "aaa") "anything at all")




(#(.length %) "aaaaaa")

(.length "aaaaa")




