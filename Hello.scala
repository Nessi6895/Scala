import scala.collection.mutable.ListBuffer

object Hello{
  def main(args: Array[String]){
    val bufferOfNodes: ListBuffer[Node] = ListBuffer()
    bufferOfNodes += new Node(1, Some(6))
    bufferOfNodes += new Node(2, Some(6))
    bufferOfNodes += new Node(3, Some(7))
    bufferOfNodes += new Node(4, Some(7))
    bufferOfNodes += new Node(5, Some(7))
    bufferOfNodes += new Node(6, Some(8))
    bufferOfNodes += new Node(7, Some(8))
    bufferOfNodes += new Node(8, None)
    val listOfNodes: List[Node] = bufferOfNodes.toList
    print("Parent node's ids: ")
    findAllChildren(listOfNodes).map((i: Node) => print(i.id + " "))
    print("\n")
    println("Childrens of 7th node: " + listOfNodes.toString)
  }
  case class Node(id: Long, parent: Option[Long], var children: List[Node] = Nil)

  def findAllChildren(nodes: List[Node]): List[Node] = {
    for(node1 <- nodes if(node1.parent != None); node2 <- nodes if(Some(node2.id) == node1.parent)){
      node2.children = node2.children + List(node1)
    }
    for(node <- nodes if node.parent == None) yield node
  }
}
