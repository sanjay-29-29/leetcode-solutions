# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
def traversal(root):
    global l,prev,max_count,current_count,result
    if root==None:return 
    traversal(root.left)
    
    current_count=1 if root.val!=prev else current_count + 1
    if current_count == max_count:
        result.append(root.val)
    elif current_count>max_count:
        result = [root.val]
        max_count = current_count
    prev = root.val
    
    traversal(root.right)
    
class Solution:
    def findMode(self, root: TreeNode) -> List[int]:
        global l,prev,max_count,current_count,result
        l = []
        prev = None
        max_count = 0
        current_count = 0 
        result = []
        traversal(root)
        return result
