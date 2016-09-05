# PercolationProblem

## The Problem:
Suppose that you have a NxM grid (N>1 and M>1) and we have a liquid that flows from a side (or bond) to the other side in front.
In a mathematical model, we suppose that every site (in our example we have NxM site) is open or blocked.
If it's open, the liquid can pass through it, and if it's not, it will block the liquid.
To check if the liquid can go from an end and reach the other end (passing by opened sites), we give every site a probability p that it's opened (this implies that the probability of a site to be closed si 1-p).
But, until now, there is no mathematical solution that can give the value of the probability p.
![alt text](https://github.com/charaneadam/PercolationProblem/blob/master/PercolationView.gif "Percolation types")
## Applications:
* In electricity, we can calculate how much we need of metallic conductors to have a current.
* In mechanics, we can have an idea on how much places in a land shoud be empty to let water flows from a side to another.
* In atomistics, it can gives us an idea on if a solid is broken or not
* In social networks, is two persons choosen arbitrary can have an chance of meeting or being friends.
* In image processing ...
* In bio ...
* ...

##The solution
This problem have many applications in physics, astronomy, chemistry, bio ... so the value of p have a big importance in real life. The approximate solution came from computer scientists.
The goal of this repository is to simulate how scientist found that solution.
Since sites can be 10 or 100000000000 we have to choose a good data structure and performant algorithms that can process that data.
The ideas of the simulation come from Professor Robert Sedgewick as an assignement to it's course : [Introduction To Algorithms](https://www.coursera.org/learn/introduction-to-algorithms "The course on Coursera")
In the solution implementation, there are some classes used from a library of Professor Robert under GPLv3 License that you can find [Here](http://algs4.cs.princeton.edu/code/algs4.jar). But they'll be explained and implemented also (only the hard parts).
