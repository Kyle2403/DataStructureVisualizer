# Overview
This program aims to visualize data structures following: 
single linked list, stack, queue, priority queue, tree and graph.
# How to use it
Open a terminal/command prompt in the project directory and run "./gradlew run".
A window will open, and you can choose one of the items in the "Data Structures" menu.
Each data structure has its own functions represented by buttons.
There are 2 buttons for linked list, stack, queue, priority queue, tree and 4 for graph.
A message will be displayed after user inputs and hit a button.
## Linked list
* InsertAfter(node1,node2) 
  * Insert node2 after node1. In case only one node is provided,it will be put at the beginning of the list. If node1 does not exist, node2 will be put at beginning as well.
  * Enter node names separated by a comma to the input and hit the button to execute. For example, enter "a" and hit the button would put it as the first node, then enter "a,b" would make b positioned after a.
* Remove(node)
  * Remove the node provided.
  * Enter node name and hit the button to execute. For example, having added node a to the list, you can enter a and hit the button to remove it.
## Stack
* Push(item)
  * Push an item to the top of the stack.
  * Enter item name and hit the button to execute. For example, enter "a" and hit the button would put an item named a at the top.
* Pop
  * This button does not require any input, simply hit, and it will remove the item at the top of the stack.
## Queue
* Enqueue(item)
  * Enqueue an item to the top of the queue.
  * Enter item name and hit the button to execute.
* Dequeue
  * This button does not need input, hit it, and it will remove the item at the bottom of the queue.
## Priority Queue
* Insert(key,value)
  * Insert an item with a key(integer) and a value to the priority queue. The items will be sorted based on the key, item with the smallest key ends up at the top.
  * Enter a pair of key,value separated by a comma and hit the button to add an item to the queue. For example, enter "1,a" would put an item with key 1 and value a to the queue.
* RemoveMin
  * This button does not need an input, hit it, and it will remove the item with the smallest key,i.e, the item at the top.
## Tree
* Add(parentNode,childNode)
  * Add a child node to a parent node. If only one node is provided and the tree is empty, then it will be the root of the tree. If 2 nodes are provided and parent node does not exist and the tree is empty, child node will be the root.
  * Enter node names separated by a comma and hit the button to execute. For example, enter "a" would make it the root, enter "a,b" would add b as child node of a.
* Remove(node)
  * Remove a node along with its subtree.
  * Enter node name and hit the button to execute. For example, assume there is a tree with a being root and b being a child of a, enter "a" and hit the button will delete the whole tree.
## Graph
* InsertVertex(vertex)
  * Insert a vertex to the graph.
  * Enter a vertex name and hit the button to execute. For example, enter "a" and hit the button would add a to the graph.
* RemoveVertex(vertex)
  * Remove a vertex from the graph and its related edges.
  * Enter a vertex name and hit the button to execute. For example, having added vertex a, enter "a" and hit the button would remove a from the graph.
* InsertEdge(vertex,vertex)
  * Add an edge between 2 given vertices.
  * Enter 2 vertices names separated by a comma and hit the button to execute. For example, enter "a,b" and hit the button would add an edge named ab between a and b.
* RemoveEdge(vertex,vertex)
  * Remove an existing edge between 2 vertices.
  * Enter 2 vertices names separated by a comma and hit the button to execute. For example, enter "a,b" and hit the button would remove an edge between a and b.
