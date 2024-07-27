/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Admin
 */
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

public class MacDark
	extends FlatMacDarkLaf
{
	public static final String NAME = "MacDark";

	public static boolean setup() {
		return setup( new MacDark() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, MacDark.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
