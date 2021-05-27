
-- CSCE 314 [Section 503] Programming Languages Spring 2021
-- Homework Assignment 2 (Total 70 points)

-- Problem 1 (5 points)
-- Student Name: Khoa Diep
-- UIN: 926005094
-- (IMPORTANT: Acknowledge any help received here)

-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

-- https://www.geeksforgeeks.org/insertion-sort/
-- Class Lecture Slides


module Main where

import Test.HUnit
import System.Exit
import Data.List
import Data.Char


-- *** Read Chapter 7 ***

-- Problem 2 (15 points)
-- Problem 2.1 (10 points) 
mergeBy :: (a -> a -> Bool) -> [a] -> [a] -> [a]
mergeBy _ xs [] = xs -- if ys is empty, base case
mergeBy _ [] ys = ys -- if xs is empty, base case 

mergeBy order (x:xs) (y:ys) 
    | order x y   = x:mergeBy order xs (y:ys) -- if x is smaller (or equal to)
    | otherwise = y:mergeBy order (x:xs) ys


halve :: [a] -> ([a], [a])  -- from HW1
halve xs = splitAt (length xs `div` 2) xs

-- Problem 2.2 (5 points) 
msortBy :: (a -> a -> Bool) -> [a] -> [a]
msortBy _ []  = []
msortBy _ [x] = [x]
msortBy order xs  = mergeBy order (msortBy order a) (msortBy order b)
 where 
  (a, b) = halve xs


-- Problem 3 (15 points)
-- Problem 3.1 (10 points) altMap
altMap :: (a -> b) -> (a -> b) -> [a] -> [b]
altMap f g []     = []
altMap f g (x:xs) = f x : altMap g f xs

{- Problem 3.2 (5 points)
   Explain how your altMap works when it is applied as below.
   > altMap (*2) (`div` 2) [0..6]
	(*2) 0 	: altMap (`div` 2) (*2) [1, 2, 3, 4, 5, 6]
	0 : altMap (`div` 2) (*2) [1, 2, 3, 4, 5, 6]
	0 : 1 'div' 2 : altMap (*2) (`div` 2) [2, 3, 4, 5, 6]
	0 : 0 : altMap (*2) (`div` 2) [2, 3, 4, 5, 6]
	0 : 0 : (*2) 2 : altMap (`div` 2) (*2) [3, 4, 5, 6]
	0 : 0 : 4 : altMap (`div` 2) (*2) [3, 4, 5, 6]
	0 : 0 : 4 : 3 `div' 2 : altMap (*2) (`div` 2) [4, 5, 6]
	0 : 0 : 4 : 1 : altMap (*2) (`div` 2) [4, 5, 6]
	0 : 0 : 4 : 1 : (*2) 4 : altMap (`div` 2) (*2) [5, 6]
	0 : 0 : 4 : 1 : 8 : altMap (`div` 2) (*2) [5, 6]
	0 : 0 : 4 : 1 : 8 : 5 `div` 2 : altMap (*2) (`div` 2) [6]
	0 : 0 : 4 : 1 : 8 : 2 : (*2) 6 : altMap (`div` 2) (*2) []
	0 : 0 : 4 : 1 : 8 : 2 : 12 : altMap (`div` 2) (*2) []
	0 : 0 : 4 : 1 : 8 : 2 : 12 : []
	= [0, 0, 4, 1, 8, 2, 12]
-}


-- Problem 4 (10 points)
concatenateAndUpcaseOddLengthStrings :: [String] -> String

myMapToUpper = map toUpper
filterOddLengthStrings  = filter(odd . length)
concatenateAndUpcaseOddLengthStrings xs = myMapToUpper(concat(filterOddLengthStrings xs))
-- OR
--concatenateAndUpcaseOddLengthStrings xs = (myMapToUpper.concat.filterOddLengthStrings) xs

-- Problem 5 (25 points)
-- Problem 5.1 (10 points)
myInsert :: Ord a => a -> [a] -> [a]
myInsert x [] = [x]
myInsert x (y:ys)
    | x <= y     = x:y:ys
    | otherwise  = y:myInsert x ys


-- Problem 5.2 (5 points)
mySort :: Ord a => [a] -> [a]
--mySort (x:xs) = foldr myInsert [x] xs
mySort xs = foldr myInsert [] xs
{- Problem 5.3 (10 points)
   Explain how your mySort works when it is applied as below.
   Your explanation should be closely related to how foldr works.
   > mySort [3,1,4,2,5]
   foldr myInsert [] [3,1,4,2,5]
   foldr myInsert [] (3:(1:(4:(2:(5:[]			)))))
   foldr myInsert [] (3:(1:(4:(2:(myInsert 5 []	)))))
   foldr myInsert [] (3:(1:(4:(2:([5]			)))))
   foldr myInsert [] (3:(1:(4:(myInsert 2 [5]	 ))))
   foldr myInsert [] (3:(1:(4:([2,5]			 ))))
   foldr myInsert [] (3:(1:(myInsert 4 [2,5]	  )))
   foldr myInsert [] (3:(1:([2, 4, 5]	 		  )))
   foldr myInsert [] (3:(myInsert 1 [2, 4, 5]	   ))
   foldr myInsert [] (3:([1, 2, 4, 5]	   		   ))
   foldr myInsert [] (myInsert 3 [1, 2, 4, 5]	    )
   foldr myInsert [] ( [1, 2, 3, 4, 5]	   			)
   [1, 2, 3, 4, 5]	
   
	
   
   
-}


    
myTestList =

  let te s e a = test $ assertEqual s e a
      tb s b = test $ assertBool s b
  in
    TestList [ 
        te "mergeBy 1" "GFEDBA" (mergeBy (>) "FED" "GBA")
      , te "mergeBy 2" "HMaouiwdy" (mergeBy (<) "Howdy" "Maui")
      
      , te "msortBy 1" " 'eggim" (msortBy (<) "gig 'em") 
      , te "msortBy 2" "nmlkieecbbaJ  " (msortBy (>) "Jack be nimble")
      , te "msortBy 3" "" (msortBy (<) "")

      , te "altMap 1" [10,200,30,400,50] (altMap (* 10) (* 100) [1,2,3,4,5])
      , te "altMap 2" False (and (altMap even odd [1..10]))
      , te "altMap 3" "hAsKeLl iS FuN!" (altMap toLower toUpper "Haskell IS fun!")

      , te "concatenateAndUpcaseOddLengthStrings"
          "HERE'S AN EXAMPLE" (concatenateAndUpcaseOddLengthStrings ["here's ", "an ", "a ", "example"])

      , te "myInsert 1" "How are you?" (myInsert 'o' "Hw are you?") 
      , te "myInsert 2" "abcdefg" (myInsert 'c' "abdefg")

      , te "mySort" "  Jabcceikkqu" (mySort "Jack be quick")
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
