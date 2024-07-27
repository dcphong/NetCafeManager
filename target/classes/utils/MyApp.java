/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import com.formdev.flatlaf.FlatIntelliJLaf;
/**
 *
 * @author Admin
 */


public class MyApp
	extends FlatIntelliJLaf
{
	public static final String NAME = "MyApp";

	public static boolean setup() {
		return setup( new MyApp() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, MyApp.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
