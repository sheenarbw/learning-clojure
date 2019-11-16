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

(/ (+ 7 (* 3 4) 5 ) 10)

; now for functions :)
; https://clojure.org/guides/learn/functions

(defn greet  [name]  (str "Hello, " name) ) ; returns the string

; use recursion to set default args. Interesting
(defn messenger
([]     (messenger "Hello world!"))
([msg]  (println msg)))


(def inputString (read-line))
(println "Hello, World.") 
(println inputString)