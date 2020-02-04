;;; Scheme code for Twenty-One Simulator

(define (twenty-one player-strategy house-strategy)
  (let ((house-initial-hand (make-new-hand (deal))))
    (let ((player-hand
           (play-hand player-strategy
                      (make-new-hand (deal))
                      (hand-up-card house-initial-hand))))
      (if (> (hand-total player-hand) 21)
          0                                ; ``bust'': player loses
          (let ((house-hand
                 (play-hand house-strategy
                            house-initial-hand
                            (hand-up-card player-hand))))
            (cond ((> (hand-total house-hand) 21)
                   1)                      ; ``bust'': house loses
                  ((> (hand-total player-hand)
                      (hand-total house-hand))
                   1)                      ; house loses
                  (else 0)))))))           ; player loses

(define (play-hand strategy my-hand opponent-up-card)
  (cond ((> (hand-total my-hand) 21) my-hand) ; I lose... give up
        ((strategy my-hand opponent-up-card) ; hit?
         (play-hand strategy
                    (hand-add-card my-hand (deal))
                    opponent-up-card))
        (else my-hand)))                ; stay

; problem 2
(define (stop-at stopAtNumber)
    (lambda (my-hand opponent-up-card)
    (< (hand-total my-hand) stopAtNumber)))

; problem 3
(define (test-strategy strat1 strat2 numberOfGames)
    (cond ((= numberOfGames 1) (twenty-one strat1 strat2))
    (else (+ (twenty-one strat1 strat2)
            (test-strategy strat1 strat2 (- numberOfGames 1))))))

; problem 4
(define (watch-player strat1)
    (lambda (self-hand house-hand)
        (print "Opponent card ")
        (print house-hand)
        (print "My hand: ")
        (print (hand-total self-hand))
        (print "Hit me? ")
        (print (strat1 self-hand house-hand))
        (newline)
        (strat1 self-hand house-hand)))

; problem 5
(define Louis
    (lambda (self-hand house-up-card)
        (cond ((< (hand-total self-hand) 12) #t)
              ((> (hand-total self-hand) 16) #f)
              ((= (hand-total self-hand) 12) (< house-up-card 4))
              ((= (hand-total self-hand) 16) (not (= house-up-card 10)))
              (else (> house-up-card 6)))))

; problem 6
(define (both strat1 strat2)
    (lambda (self-hand opponent-up-card)
        (and (strat1 self-hand opponent-up-card) (strat2 self-hand opponent-up-card))))

(define (deal) (+ 1 (random 10)))

(define (make-new-hand first-card)
  (make-hand first-card first-card))

(define (make-hand up-card total)
  (cons up-card total))

(define (hand-up-card hand)
  (car hand))

(define (hand-total hand)
  (cdr hand))

(define (hand-add-card hand new-card)
  (make-hand (hand-up-card hand)
             (+ new-card (hand-total hand))))

(define (hit? your-hand opponent-up-card)
  (newline)
  (print "Opponent up card ")
  (print opponent-up-card)
  (newline)
  (print "Your Total: ")
  (print (hand-total your-hand))
  (newline)
  (print "Hit? ")
  (user-says-y?))


(define (user-says-y?) (eq? (read) 'y))
