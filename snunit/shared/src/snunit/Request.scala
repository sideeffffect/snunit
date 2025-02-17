package snunit

trait Request {
  def method: Method
  def version: String
  def headers: Seq[(String, String)]
  def headersLength: Int
  def headerName(index: Int): String
  def headerNameUnsafe(index: Int): String
  def headerValue(index: Int): String
  def headerValueUnsafe(index: Int): String
  def content: String = new String(contentRaw)
  def contentRaw: Array[Byte]
  def target: String
  def path: String
  def query: String
  def send(statusCode: StatusCode, content: Array[Byte], headers: Seq[(String, String)]): Unit
  def send(statusCode: StatusCode, content: String, headers: Seq[(String, String)]): Unit = {
    send(statusCode, content.getBytes(), headers)
  }
  def startSend(statusCode: StatusCode, headers: Seq[(String, String)]): Unit
  def sendBatch(data: Array[Byte]): Unit
  def sendBatch(data: Array[Byte], off: Int, len: Int): Unit
  def sendDone(): Unit
}
