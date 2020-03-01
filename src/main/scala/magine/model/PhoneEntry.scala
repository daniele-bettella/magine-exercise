package magine.model

case class PhoneEntry(name: String, number: String, id: String = java.util.UUID.randomUUID.toString) {

}
