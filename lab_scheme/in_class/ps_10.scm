; What does the following Scheme function do?
(define (x lis)
  (cond
    ((null? lis) 0)
    ((not (list? (car lis)))
       (cond
         ((eq? (car lis) #f) (x (cdr lis)))
         (else (+ 1 (x (cdr lis))))))
    (else (+ (x (car lis)) (x (cdr lis))))
