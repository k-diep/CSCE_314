
-- CSCE 314 [Section 503] Programming Languages Spring 2021
-- Homework Assignment 1 (Total 130 points)

-- Problem 1 (5 points)
-- This is head comment (single line comment should be preceded by two dashes)
-- Student Name: Khoa Diep
-- UIN: 926005094
-- (ACKNOWLEDGE ANY HELP RECEIVED HERE)
-- https://www.geeksforgeeks.org/merge-sort/


-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit  -- if this line causes compile error, try the following
                   -- command at the terminal prompt > cabal v1-install HUnit
import System.Exit


-- Example:
-- Write a recursive function mySum that sums all the numbers
-- in a list without using the prelude function sum.
mySum :: [Int] -> Int  -- type signature of mySum. mySum accepts a list of Ints
                       -- as its argument and returns an Int
mySum []     = 0  -- def 1
mySum (x:xs) = x + mySum xs -- def 2

{- Block comment over multiple lines is enclosed within {- and -}
Explanation:
The type of mySum tells us that mySum takes a list of Ints as an argument
and returns an Int that is the sum of all the Ints in the argument list.

The def 1 of mySum is the base case of the recursion, that is,
the argument list is empty, for which case the function value is 
defined as zero (summation identity).

The def 2 is when the argument list contains at least one element, 
namely x, in which case the function is defined as the sum of x 
and the result of the recursive call of mySum applied to the rest of 
the argument list, namely xs.
-}


-- Problem 2 (10 points)
lucas :: Int -> Int
lucas 0 = 2
lucas 1 = 1
lucas n = lucas(n-1) + lucas(n-2)

{-
Explanation:
The type of lucas tells us that lucas takes a value of type Int and returns
and Int that follows that recursive function. 

The def 1 and def 2 of lucas is the base case of the recursion.
That is if the argument is 0, that return is 2 and if the argument is 1
the return is 1. 

The def 3 is when the argument is greater than 2, namely x. 
The result of the recursive call of lucas is lucas(n-1) + lucas(n-2), or in other words
the sum of the last two arguments.
-}


-- Problem 3 (5+5 = 10 points)
qsort1 :: Ord a => [a] -> [a]
---- Question 3.1 (5 points)
qsort1 [] = []
qsort1 (x:xs) = qsort1 larger ++ [x] ++ qsort1 smaller
 where 
  larger  = [a | a <- xs, a > x]
  smaller = [b | b <- xs, b <= x]


---- Question 3.2 (5 points)
{- Write your answer for Question 4.2 within this block comment.
Explanation:
The type of qsort1 tells us that qsort1 takes a value of type that is type a list of type Ord and returns
a list of type Ord. 

The base case tells us where to stop, in particular, if it is an empty list, then the function stops. 

The recursive case tells us to append the lists larger, x and smaller in that order. 
Where x is the first element of the argument's list, larger is all of the values bigger 
than x and smaller is all of the values less than or equal to x.

	= qsort1 [3, 2, 3, 1, 4]. x = 3, larger = [4], smaller = [2, 3, 1]
	= qsort1 [4] ++ [3] ++ qsort1 [2, 3, 1]
	= ([] ++ [4] ++ []) ++ [3] ++ (qsort1[3] ++ [2] ++ qsort1 [1])
	= [4] ++ [3] ++ ((] ++ [3] ++ [] ++ [2] ++ [] ++ [1] ++ [])
	= [4] ++ [3] ++ ([3] ++ [2] ++ [1])
	= [4, 3, 3, 2, 1]

Counting the number of qsort1 functions, qsort1 is called 4 times, without counting the times the base case is called upon. 
If the base case counts, then qsort1 is called 10 times. 
-}


-- Problem 4 (Chapter 5, Exercise 9) (10+5=15 points)
scalarproduct :: [Int] -> [Int] -> Int
---- Question 4.1 (10 points)
scalarproduct xs ys = sum [x*y | (x, y) <- zip xs ys ]


---- Question 4.2 (5 points)
{-
scalarproduct [1, 2, 3] [4..]
	= sum [x*y | (x, y) <- zip [1, 2, 3] [4..]    ]
	= sum [x*y | (x, y) <- [(1, 4), (2, 5), (3, 6)]
	= sum [1*4, 2*5, 3*6]
	= sum [4, 10, 18]
	= 4 + 10 + 18
	= 32
	
-}



-- Problem 5 (Chapter 6, Exercise 7) (10 points)
merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs -- if ys is empty, base case
merge [] ys = ys -- if xs is empty, base case 
merge (x:xs) (y:ys) | x <= y      = x:merge xs (y:ys) -- if x is smaller (or equal to)
                    | otherwise   = y:merge (x:xs) ys -- if y is smaller



-- Problem 6 (Chapter 6, Exercise 8) (7+8=15 points)
halve :: [a] -> ([a], [a])  -- 7 points
halve xs = splitAt (length xs `div` 2) xs
-- Using splitAt the middle( which is calculated with (length xs `div` 2))

msort :: Ord a => [a] -> [a]  -- 8 points
msort []  = []
msort [x] = [x]
msort xs  = merge (msort a) (msort b)
 where 
  (a, b) = halve xs



-- Problem 7 (10 points)
isElem :: Eq a => a -> [a] -> Bool
isElem x [] = False -- base case
isElem x (y:ys) | x == y = True
                | otherwise = isElem x ys


type Set a = [a]

-- Problem 8 (10 points)
toSet :: Eq a => [a] -> Set a
toSet [] = []
toSet (x:xs) | isElem x xs == False = x:toSet xs -- if x is not in list
             | otherwise = toSet xs              -- if x is in list


-- Problem 9 (10 points) Using isElement in the definition is required.
subset :: Eq a => Set a -> Set a -> Bool
subset [] _ = True
subset (x:xs) y | isElem x y = subset xs y
                | otherwise          = False


-- Problem 10 (10 points) Using subset in the definition is required.
setEqual :: Eq a => Set a -> Set a -> Bool
setEqual x y | (subset x y && subset y x) = True 
             | otherwise                  = False
-- NOTE: not recursion



-- Problem 11 (10+15=25 points)
powerset :: Set a -> Set (Set a)
---- Question 11.1 (10 points)
powerset []     = [[]]
powerset (x:xs) = map (x:) (powerset xs) ++ powerset xs

---- Question 11.2 (15 points)
{- Write your answer for Question 11.2 within this block comment.
powerset [3, 2, 4]
 = map (3:) powerset [2, 4] ++ powerset [2, 4]
 
powerset [2, 4]
 = map (2:) powerset [4] ++ powerset [4]
 
powerset[4]
 = map (4:) powerset [] ++ powerset []
 = map (4:) [[]] ++ [[]]
 = [[[4]],[]]
 
Therefore,
powerset [2, 4]
 = map (2:) powerset [4] ++ powerset [4]
 = map (2:) [[[4]],[]] ++ [[[4]],[]]
 = [[2,4], [2], [4], []]

Therefore,
powerset [3, 2, 4]
 = map (3:) [[2,4],[4],[]] ++ [[2,4],[4],[] ]
 = [[3, 2, 4], [3, 2], [3, 4], [3], [2, 4], [4], []]
 
-}



myTestList = 
  TestList [

      "lucas 1" ~: lucas 0 ~=? 2
    , "lucas 2" ~: lucas 1 ~=? 1    
    , "lucas 3" ~: lucas 4 ~=? 7
    
    , "qsort1 1" ~: qsort1 [3, 2, 5, 1, 6] ~=? [6,5,3,2,1]
    , "qsort1 2" ~: qsort1 "howdy" ~=? "ywohd"
    
    , "scalarproduct 1" ~: scalarproduct [4,5,6] [1,2,3] ~=? 32
    , "scalarproduct 2" ~: scalarproduct [2,3] [1,-1] ~=? -1
    , "scalarproduct 3" ~: scalarproduct [1..10] [1..5] ~=? 55

    , "merge 1" ~: merge "EGG" "ABCDEFGH" ~=? "ABCDEEFGGGH" 
    , "merge 2" ~: merge "Hello" "e" ~=? "Heello"

    , "halve 1" ~: halve "" ~=? ("","")
    , "halve 2" ~: halve "halves" ~=? ("hal","ves")
    , "halve 21" ~: halve "halve" ~=? ("ha","lve")

    , "msort 1" ~: msort "Howdy all!" ~=? " !Hadllowy"
    , "msort 2" ~: msort "" ~=? ""
    , "msort 3" ~: msort "Mississippi" ~=? "Miiiippssss"

    , "isElem 1" ~: (isElem 'h' "happy") ~=? True
    , "isElem 2" ~: (isElem 'o' "happy") ~=? False

    , "toSet 1" ~: length (toSet "aardvark") ~=? 5
    , "toSet 2" ~: length (toSet "BartBart") ~=? 4

    , "subset 1" ~: subset [] [1,2] ~=? True
    , "subset 2" ~: subset [1,2] [] ~=? False
    , "subset 3" ~: subset [2,3] [1,2] ~=? False
    , "subset 4" ~: subset [2,3] [3,1,2] ~=? True
    , "subset 5" ~: subset [2,3] [2,1,4] ~=? False

    , "setEqual 1" ~: setEqual "abc" "bca" ~=? True
    , "setEqual 2" ~: setEqual [1,2] [2,1] ~=? True
    , "setEqual 3" ~: setEqual [1,2,3] [1,2,3,4] ~=? False
    , "setEqual 4" ~: setEqual [2,3,1] [1,2,3] ~=? True

    , "powerset 1" ~: length (powerset ([]::[Int])) ~=? 1
    , "powerset 2" ~: length (powerset [5]) ~=? 2
    , "powerset 3" ~: length (powerset [3,2]) ~=? 4
    , "powerset 4" ~: length (powerset "abc") ~=? 8

    ]

main = do c <- runTestTT myTestList
          putStrLn $ show c
          let errs = errors c
              fails = failures c
          exitWith (codeGet errs fails)
          
codeGet errs fails
 | fails > 0       = ExitFailure 2
 | errs > 0        = ExitFailure 1
 | otherwise       = ExitSuccess

