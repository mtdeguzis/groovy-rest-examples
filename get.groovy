import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

url = "http://restapi3.apiary.io"

@Grab (group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.5.0')
def client = new RESTClient(url)

def emptyHeaders = [:]
emptyHeaders."Accept" = 'application/json'
emptyHeaders."Prefer" = 'test'

def response = client.get(path: "/notes",
  headers: emptyHeaders

println("Status: " + response.status)
if (response.data) {
  println("Content Type: " + response.contentType)
  println("Headers: " + response.getAllHeaders())
  println("Body:\n" + JsonOutput.prettyPrint(JsonOutput.toJson(response.data)))
}
