package TestContext;

import java.util.HashMap;
import java.util.Map;
import enums.TestData;

public class ScenarioContext {

	private Map<String, Object> scenarioContext;

	public ScenarioContext() {

		scenarioContext = new HashMap<String, Object>();

	}

	public void setContext(TestData key, Object value) {

		scenarioContext.put(key.toString(), value);

	}

	public Object getContext(TestData key) {

		return scenarioContext.get(key.toString());

	}

	public Boolean isContains(TestData key) {

		return scenarioContext.containsKey(key.toString());

	}

}
