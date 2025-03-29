Approach:
Identify the Corners:
First, identify the indexes of all four corners: top, bottom, left, and right.

While Loop:
Set up a while loop to keep traversing the matrix until:
top is less than bottom
left is less than right

Traversal Order:
Left to Right: Traverse the top row from left to right and add each element to the result array.
Then, increment top (i.e., move down to the next row).
Top to Bottom: Traverse the rightmost column from top to bottom.
Then, decrement right (i.e., move left to the next column).
Right to Left: If top is still less than bottom, traverse the bottom row from right to left.
Then, decrement bottom (i.e., move up to the next row).
Bottom to Top: If left is still less than right, traverse the leftmost column from bottom to top.
Then, increment left (i.e., move right to the next column).
Repeat the above steps until the entire matrix is traversed in spiral order.
