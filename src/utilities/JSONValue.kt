package utilities


sealed class JSONValue {
	class JSONObject(val value: Map<String, JSONValue>) : JSONValue()
	class JSONArray(val value: List<JSONValue>) : JSONValue()
	class JSONString(val value: String) : JSONValue()
	class JSONNumber(val value: Double) : JSONValue()
	object JSONTrue : JSONValue()
	object JSONFalse : JSONValue()
	object JSONNull : JSONValue()
	
}
