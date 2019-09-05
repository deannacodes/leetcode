
class Solution {
    var orderNode: TreeNode?
    var orderNodePrev: TreeNode?
    
    func increasingBST(_ root: TreeNode?) -> TreeNode? {        
        traverse(root: root)        
        return orderNode        
    }
    
    func traverse(root: TreeNode?) {
        if let root = root {
            traverse(root: root.left)
            
            if let _ = orderNode {
                orderNodePrev?.right = root
            } else {
                orderNode = root
            }
            orderNodePrev = root
            root.left = nil            
            
            traverse(root: root.right)
        } else {
            return
        }
    }
}