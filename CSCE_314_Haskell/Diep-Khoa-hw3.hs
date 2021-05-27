
-- CSCE 314 [Section 503] Programming Languages Spring 2021
-- Homework Assignment 3 (Total 100 points)

-- Problem 1 (5 points)
-- Student Name: Khoa Diep
-- UIN: 926005094
-- https://stackoverflow.com/questions/26618059/how-to-print-the-same-char-n-times-in-haskell
-- https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
-- On my honor, as an Aggie, I have neither given nor received any unauthorized
-- aid on any portion of the academic work included in this assignment.

module Main where

import Test.HUnit
import System.Exit

-- *** Read Chapters 8 and 16 ***

data Tree2 a b = Leaf2 a | Branch b (Tree2 a b) (Tree2 a b)

--------------- Tree2 objects
tree2a :: Tree2 Int String -- to be used to test Problems 2 and 3
tree2a = Branch "A" 
            (Branch "B" 
               (Leaf2 1) 
               (Leaf2 2)) 
            (Leaf2 3)

tree2b :: Tree2 Int String -- to be used to test Problems 2 and 3
tree2b = Branch "+" 
            (Branch "*" 
               (Leaf2 3)
               (Branch "+" (Leaf2 4) (Leaf2 5)))
            (Branch "+"
               (Branch "*" (Leaf2 6) (Leaf2 7))
               (Leaf2 8))
---------------

-- Problem 2 (15 points)
instance (Show a, Show b) => Show (Tree2 a b) where
   show = showHelper 0 --depth is represented by 0 (basecase)
      where
        showHelper depth (Leaf2 x) = replicate depth '\t' ++ show x-- if leaf2
        showHelper depth (Branch x (leftTree) (rightTree)) = replicate depth '\t' ++ show x ++ ['\n'] ++ showHelper(depth + 1) (leftTree) ++ ['\n'] ++  showHelper(depth + 1) (rightTree)
        -- This one evaluates the right tree first (if uncomment the next line and comment/delete the previous line)
        --showHelper depth (Branch x (leftTree) (rightTree)) = replicate depth '\t' ++ show x ++ ['\n'] ++ showHelper(depth + 1) (rightTree) ++ ['\n'] ++  showHelper(depth + 1) (leftTree)


-- Problem 3 (15 points)
preorder  :: (a -> c) -> (b -> c) -> Tree2 a b -> [c]  -- 8 points
preorder f g (Leaf2 b)                         = [f b]
preorder f g (Branch x (leftTree) (rightTree)) = [g x] ++ preorder f g leftTree ++ preorder f g rightTree

inorder   :: (a -> c) -> (b -> c) -> Tree2 a b -> [c]  -- 7 points
inorder f g (Leaf2 b)                         = [f b]
inorder f g (Branch x (leftTree) (rightTree)) = inorder f g leftTree ++ [g x] ++ inorder f g rightTree

-- Problem 4 (10 + 15 = 25 points)
-- Chapter 16, Exercise 6 (Modified)

data Tree = Leaf Int | Node Tree Tree

--------------- Tree objects
tree1 :: Tree   -- to be used to test Problem 4.1
tree1 = Node
           (Node
              (Node (Leaf 1) (Leaf 2))
              (Leaf 3)
           )
           (Node
              (Leaf 4)
              (Node (Leaf 5) (Leaf 6))
           )

tree2 :: Tree   -- to be used to test Problem 4.1
tree2 = Node
           (Leaf 7)
           (Node
              (Node (Leaf 8) (Leaf 9))
              (Node (Leaf 10) (Leaf 11))
           )
---------------

-- Problem 4.1 (5 + 5 = 10 points)
leaves :: Tree -> Int
leaves (Leaf _)                      = 1                                  -- base case
leaves (Node (leftTree) (rightTree)) = leaves leftTree + leaves rightTree -- recursive case

nodes :: Tree -> Int
nodes (Leaf _)                      = 0
nodes (Node (leftTree) (rightTree)) = 1 + nodes leftTree + nodes rightTree
-- Problem 4.2 (Base case 5 points + inductive case 10 points = 15 points)
{-- (Write your induction proof within this block comment.)
Given: leaves t = nodes t + 1

Base case: A non-empty tree with 0 nodes has exactly 1 leaf.  A tree with exactly 1 node has to have two leaves, (it cannot have another node since that 
will increase the number of nodes by 1 and having another node is the only other option). 


Induction Hypothesis: Given tree T with n-1 nodes, the tree has n leaves.
Inductive case: (Make sure that you state the induction hypothesis!)

Let us a tree T with internal nodes, choose an internal node, denoted by A, where the children of the node are both leaves. If we remove A's children from the tree,
we get a new Tree, denoted by T2. T2 has n-1 nodes, since A turned into a node to a leaf. From the induction hypothesis, T2 has n leaves and n-1 nodes. 

However, if we add the two childen back to A, A turns back into node from a leaf. This increases the nodes from n-1 to n. Since we added two leaves, but removed one leaf
(again A turned from leaf to node going from T2 to T), the total number of leaves increase by 2 - 1 = 1. Since T2 has n leaves, T has n + 1 leaves. All together, T has n 
nodes and n + 1 leaves.

By induction, the claim leaves t = nodes t + 1 is proven.
--}


-- Problem 5 (40 points) Chapter 8, Exercise 9
data Expr = Val Int | Add Expr Expr | Mul Expr Expr

type Cont = [Op]

data Op = EVALA Expr | ADD Int | EVALM Expr | MUL Int

eval :: Expr -> Cont -> Int
-- Give three definitions for eval.
-- First two definitions,
-- 1) for (Val n) and c as arguments and
-- 2) for (Add x y) and c as arguments
-- are already given in the text Section 8.7, but
-- you need to modify the second definition slightly
-- and give the third definition for (Mul x y)
eval (Val n)   c = exec c n
eval (Add x y) c = eval x (EVALA y : c)
eval (Mul x y) c = eval x (EVALM y : c)

exec :: Cont -> Int -> Int
-- Give five definitions for exec, one for an empty list and
-- one for each of the four constructors of the data type Op
-- Some of these are already given in the text Section 8.7.
exec []           n = n
exec (EVALA y :c) n = eval y (ADD n : c)
exec (ADD n : c)  m = exec c (n+m)
exec (EVALM y :c) n = eval y (MUL n : c)
exec (MUL n : c)  m = exec c (n*m)

value :: Expr -> Int
value e = eval e []

-- Following expressions are to test your eval and exec definitions
-- (2 + 3) + 4 = 9
e1 = (Val 3)    -- 3
e2 = (Add (Val 4) (Val 3))  -- 4 + 3 = 7
e3 = (Mul (Val 4) (Val 3))  -- 4 * 3 = 12
e4 = (Add (Add (Val 2) (Val 3)) (Val 4))  -- (2 + 3) + 4 = 9
e5 = (Mul (Mul (Val 2) (Val 3)) (Val 4))  -- (2 * 3) * 4 = 24
e6 = (Mul (Add (Val 2) (Val 3)) (Val 4))  -- (2 + 3) * 4 = 20
e7 = (Add (Mul (Val 2) (Val 3)) (Val 4))  -- (2 * 3) + 4 = 10
e8 = (Add (Mul (Val 2) (Val 3)) (Add (Val 4) (Val 5))) -- (2 * 3) + (4 + 5) = 15
e9 = (Mul (Add (Val 2) (Val 3)) (Add (Val 4) (Val 5))) -- (2 + 3) * (4 + 5) = 45
e10 = (Add (Mul (Add (Val 2) (Val 3)) (Mul (Val 4) (Val 5))) (Mul (Val 3) (Add (Val 4) (Val 7)))) -- ((2 + 3) * (4 * 5)) + (3 * (4 + 7)) = 133


myTestList = 
  TestList [
  
    "preorder 1" ~: (concat (preorder show id tree2a)) ~=? "AB123"
  , "inorder 1"  ~: (concat (inorder show id tree2a))  ~=? "1B2A3"
  , "preorder 2" ~: (concat (preorder show id tree2b)) ~=? "+*3+45+*678"
  , "inorder 2"  ~: (concat (inorder show id tree2b))  ~=? "3*4+5+6*7+8"
 
  , "leaves 1" ~: leaves tree1 ~=? 6
  , "leaves 2" ~: leaves tree2 ~=? 5
  , "nodes 1"  ~: nodes tree1 ~=? 5
  , "nodes 1"  ~: nodes tree2 ~=? 4

  , "value 1"  ~: value e1 ~=? 3
  , "value 2"  ~: value e2 ~=? 7
  , "value 3"  ~: value e3 ~=? 12
  , "value 4"  ~: value e4 ~=? 9
  , "value 5"  ~: value e5 ~=? 24
  , "value 6"  ~: value e6 ~=? 20
  , "value 7"  ~: value e7 ~=? 10
  , "value 8"  ~: value e8 ~=? 15
  , "value 9"  ~: value e9 ~=? 45
  , "value 10" ~: value e10 ~=? 133
  
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

