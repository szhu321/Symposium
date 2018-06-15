package myutilities;

public class ControlItem
{
	private String controlName;
	private String defaultControlStr;
	private String currentControlStr;
	
	/**
	 * A control item is a item that binds a control with a certain user input.
	 * Ex. the control item called Up would have a default string of W, indicating that 
	 * when the user press W the in game character would move up.
	 * @param name The name of the control item. Ex. move up
	 * @param controlStr The KeyCode.toString() or MouseButton.toString() of the control item. In
	 * other words the key press or mouse press the user performs to do the action indicated 
	 * by the name of this control item.
	 */
	public ControlItem(String name, String controlStr)
	{
		controlName = name;
		defaultControlStr = controlStr;
		currentControlStr = controlStr;
	}

	public String toString()
	{
		return "Name: " + controlName + " ControlInput: " + currentControlStr;
	}
	
	public String getControlName()
	{
		return controlName;
	}

	public String getDefaultControlStr()
	{
		return defaultControlStr;
	}

	public String getCurrentControlStr()
	{
		return currentControlStr;
	}

	public void setCurrentControlStr(String currentControlStr)
	{
		this.currentControlStr = currentControlStr;
	}
	
}
