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
    for(nodeOld <- nodes; nodeYoung <- nodes if nodeYoung != nodeOld){
      if(nodeOld.id == nodeYoung.parent) nodeOld.children = (nodeOld.children.to[ListBuffer] += nodeYoung).toList
    }
    for(node <- nodes if node.parent == None) yield node
  }
}
