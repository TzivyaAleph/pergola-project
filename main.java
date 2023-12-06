import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class
import Beam.Beam;

class main {
    public static void main(String[] args) {
        Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like the Pro version? (Y/N)");
        String ans = myObj1.nextLine();  // Read user input
        if(Objects.equals(ans, "Y"))
            { Pro();}
        else
            { Regular();}
    }
    public static void regular()
    {
        userInputRegular()

    }
    /**
     * The function takes care of the regular version.
     * It gets from the user the length, width and hight of the space, the thickness of a beam, the incline and exit meter.
     */
    public static void userInputRegular()
    {
        System.out.println("Regular");  // Output user input
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter length: (in cm)");
        float length = myObj.nextFloat();  // Read user input
        System.out.println("Please enter width: (in cm)");
        float width = myObj.nextFloat();  // Read user input
        System.out.println("Please enter beam thickness: (in cm)");
        float beamThickness = myObj.nextFloat();  // Read user input
        System.out.println("Please enter incline: (in cm)");
        float incline = myObj.nextFloat();  // Read user input
        System.out.println("Please enter output of beam: (in cm)");
        float output = myObj.nextFloat();  // Read user input
        System.out.println("Please enter the hight: (in cm)");
        float hight = myObj.nextFloat();  // Read user input

    }
    /**
     * Prints the data of the regular version:
     * amount of space between beams, amount of beams, length of a wood, hight of a pole, the amount of space between the poles,
     * amount of poles needed.
     */
    public static void printRegularData(float lenght, float width, float beamThickness, float incline, float output,float hight)
    {
        float space = numOfSpaceBetweenBeam(width, beamThickness);
        System.out.println("amount of space between beams: " + space);
        float numOfBeams = numOfBeam(width, beamThickness);
        System.out.println("amount of beam: " + numOfBeams);
        float lengthOfWood = lengthOfWood(length, incline, output);
        System.out.println("the lenght of a wood: " + lengthOfWood);
        float hightOfPole = hightOfPole(hight, incline, beamThickness, length);
        System.out.println("the hight of a amud: " + hightOfPole);
        float numOfSpaceBetweenPoles = numOfSpaceBetweenPoles(width, beamThickness);
        System.out.println("amount of space between amuds: " + numOfSpaceBetweenPoles);
        float numOfPoles= numOfPoles(width, beamThickness);
        System.out.println("amount of amuds: " + numOfPoles);
    }
    /**
     * The function takes care of the pro version.
     * It gets from the user the input of the reguler version + all the lengths of a specific beam.
     */
    public static void pro()
    {
        System.out.println("Pro");  // Output user input
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //Regular();
        String ans1;
        public List<Beam> beams = new ArrayList<>();
        do {
            Beam beam1 = new Beam();
            System.out.println("Please enter beam details: (in cm)");
            System.out.println("Please enter hight: (in cm)");
            beam1.hight = myObj.nextFloat();
            System.out.println("Please enter thickness: (in cm)");
            beam1.bean_thickness = myObj.nextFloat();
            System.out.println("Please enter length: (in cm)");
            beam1.lengths.add(myObj.nextFloat());
            System.out.println("Would you like to enter another length of beam? (Y/N)");
            String ans = myObj.nextLine();
            while(Objects.equals(ans, "Y"))
            {
                System.out.println("Please enter length: (in cm)");
                beam1.lengths.add(myObj.nextFloat());
                System.out.println("Would you like to enter another length of beam? (Y/N)");
                ans = myObj.nextLine();
            }
            System.out.println("Would you like to enter another kind of beam? (Y/N)");
            ans1 = myObj.nextLine();
            beams.add(beam1);
        } while(Objects.equals(ans1, "Y"));
        public List<Beam> neededBeams = new ArrayList<>();
        neededBeams = shadowingCalculation(beams);
    }

    public static List<beam> shadowingCalculation(List<beam> beams)
    {
        
    }

    /**
     * Returns the number of beams that the user will need.
     */
    public static float numOfBeam(float width, float thickness)
    {
        //divides the width by 75 because between each beam it can't go over 75 cm.
        int x = (int)width / 75; 
        //the amount of beams (+ 1 for the last one) multiply by the thickness, to know how much room the beams take.
        float y = (x + 1) * thickness; 
        //the width minus the room that the beams take.
        float z = width - y;
        //divides the width that was left by the amount of beams.
        float result = z / x;
        //while the space between the beams are over 75 cm it adds another beam and calculets again.
        while (result >= 75)
        {
            x = x + 1;
            y = (x + 1) * thickness;
            z = width - y;
            result = z / x;
        }
        //returns the amount of beams needed.
        return x+1;
    }

    public static float numOfSpaceBetweenBeam(float width, float thickness)
    {
        int x = (int)width / 75;
        float y = (x + 1) * thickness;
        float z = width - y;
        float result = z / x;
        while (result >= 75)
        {
            x = x + 1;
            y = (x + 1) * thickness;
            z = width - y;
            result = z / x;
        }
        return result;
    }
    /**
     * 
     */
    public static float lengthOfWood(float length, float incline, float output)
    {
        return length+output+(incline/100*length);//????
    }
    /**
     * 
     */
    public static float hightOfPole(float hight, float incline, float beamThicknss, float length)
    {
        return hight-beamThicknss-(incline/100*length);
    }
    /**
     * 
     */
    public static float numOfSpaceBetweenPoles(float width, float beamThicknss)
    {
        if (beamThicknss <= 7)
        {
            int x = (int) width / 300;
            float y = (x + 1) * beamThicknss;
            float z = width - y;
            float result = z / x;
            while (result > 300) {
                x = x + 1;
                y = (x + 1) * beamThicknss;
                z = width - y;
                result = z / x;
            }
            return result;
        }
        else
        {
            int x = (int) width / 400;
            float y = (x + 1) * beamThicknss;
            float z = width - y;
            float result = z / x;
            while (result > 400) {
                x = x + 1;
                y = (x + 1) * beamThicknss;
                z = width - y;
                result = z / x;
            }
            return result;
        }
    }
    /**
     * 
     */
    public static float numOfPoles(float width, float beamThicknss)
    {
        if (beamThicknss <= 7)
        {
            int x = (int) width / 300;
            float y = (x + 1) * beamThicknss;
            float z = width - y;
            float result = z / x;
            while (result > 300) {
                x = x + 1;
                y = (x + 1) * beamThicknss;
                z = width - y;
                result = z / x;
            }
            return x+1;
        }
        else
        {
            int x = (int) width / 400;
            float y = (x + 1) * beamThicknss;
            float z = width - y;
            float result = z / x;
            while (result > 400) {
                x = x + 1;
                y = (x + 1) * beamThicknss;
                z = width - y;
                result = z / x;
            }
            return x+1;
        }
    }

}

