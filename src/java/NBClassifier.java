
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class NBClassifier {

    ArrayList<String> trainingDocs;
    ArrayList<Integer> trainingLabels;
    int numClasses = 4;
    int[] classCounts; // number of docs per class
    String[] classStrings; // concatenated string for a given class
    int[] classTokenCounts; // total number of tokens per class
    HashMap<String, Double>[] condProb;
    HashSet<String> vocabulary;
    static String[] myDocs;
    StringBuffer sb = new StringBuffer();
      ArrayList<String> stopList;

        String f = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/stopwords.txt";
        //  File f = new File("/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/stopwords.txt ");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String a = "", lines = "";

    /**
     * Build a Naive Bayes classifier using a training document set
     *
     * @param trainDataFolder the training document folder
     */
    public NBClassifier(String trainDataFolder) throws FileNotFoundException, IOException {
        File path = new File(trainDataFolder);
        trainingDocs = new ArrayList<String>();
        trainingLabels = new ArrayList<Integer>();
        classCounts = new int[numClasses];
        classStrings = new String[numClasses];
        classTokenCounts = new int[numClasses];
        condProb = new HashMap[numClasses];
        vocabulary = new HashSet<String>();
        String[] files = path.list();
      

        for (int i = 0; i < files.length; i++) {	//System.out.println(path + "/" + files[i]);
            File read = new File(path + "/" + files[i]);
            String[] fileNames = read.list();
            for (int j = 0; j < fileNames.length; j++) {
                //System.out.println(fileNames[j]+"%^$%^$#"+read);
                try {
                    Scanner scan = new Scanner(new File(read + "/"
                            + fileNames[j]));
                    // System.out.println(read+"/"+fileNames[j]);
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        sb = sb.append(line);
                    }
                    // System.out.println(sb.toString());
                    trainingDocs.add(sb.toString());
                    trainingLabels.add(i);
                    sb.setLength(0);

                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        System.out.println(trainingDocs.size() + "*****" + trainingLabels.size());
        for (int m = 0; m < numClasses; m++) {
            classStrings[m] = "";
            //System.out.println(classStrings[0]);
            condProb[m] = new HashMap<String, Double>();
            //System.out.println(condProb[0]);
        }
        for (int n = 0; n < trainingLabels.size(); n++) {
            classCounts[trainingLabels.get(n)]++;

            classStrings[trainingLabels.get(n)] += (trainingDocs.get(n) + " ");
					//System.out.println(classStrings[0]);

        }
        System.out.println("Attorney: " + classCounts[1] + " Computer: " + classCounts[0] + " MBA: " + classCounts[2]+" Misc:"+classCounts[3]);
        
        stopList=new ArrayList<String>();
        while ((a = br.readLine()) != null) {
            lines += " " + a.toLowerCase();
        }
        // System.out.println(lines);
        String line[]=lines.split("\\W");
        for(String ab:line)
            stopList.add(ab);
        Collections.sort(stopList);
        
        for (int l = 0; l < numClasses; l++) {
            String[] tokens = classStrings[l].split("[\" •()'_:,/;%-]+");
            classTokenCounts[l] = tokens.length;
					//collecting the counts

           Stemmer st=new Stemmer();
            for (String token : tokens) {
                if(stopList.contains(token)==false)
                {
                  st.stem();
                  st.add(token.toCharArray(),token.length());
                  token=st.toString();
                vocabulary.add(token);
                if (condProb[l].containsKey(token)) {
                    double count = condProb[l].get(token);
                    condProb[l].put(token, count + 1);
                } else {
                    condProb[l].put(token, 1.0);
                }
                }
            }
        }
        //computing the class conditional probability
        for (int k = 0; k < numClasses; k++) {
            Iterator<Map.Entry<String, Double>> iterator = condProb[k].entrySet().iterator();
            int vSize = vocabulary.size();
            while (iterator.hasNext()) {
                Map.Entry<String, Double> entry = iterator.next();
                String token = entry.getKey();
                Double count = entry.getValue();
                count = (count + 1) / (classTokenCounts[k] + vSize);
                condProb[k].put(token, count);
                //System.out.println(condProb[k]);
            }
            System.out.println(condProb[k]);
        }
    }

    public int classfiy(String doc) throws IOException {
        int label = 0;
        int vSize = vocabulary.size();
        double[] score = new double[numClasses];
        
        
        for (int i = 0; i < score.length; i++) {
            score[i] = Math.log(classCounts[i] * 1.0 / trainingDocs.size());
        }
        stopList=new ArrayList<String>();
        while ((a = br.readLine()) != null) {
            lines += " " + a.toLowerCase();
        }
        // System.out.println(lines);
        String line[]=lines.split("\\W");
        for(String ab:line)
            stopList.add(ab);
        Collections.sort(stopList);
        String[] tokens = doc.split("[\" •()'_:,/;%-]+");
        
        
            
        Stemmer st=new Stemmer();
        for (int i = 0; i < numClasses; i++) 
        {
            for (String token : tokens) 
            {
                if(stopList.contains(token)==false)
                {
                  st.stem();
                  st.add(token.toCharArray(),token.length());
                  token=st.toString();
                vocabulary.add(token);
                if (condProb[i].containsKey(token)) 
                {
                    score[i] += Math.log(condProb[i].get(token));
                } else {
                    score[i] += Math.log(1.0 / (classTokenCounts[i] + vSize));
                }
            }
            }
        }
        
        double maxScore = score[0];
        for (int i = 0; i < score.length; i++) {
            if (score[i] > maxScore) {
                label = i;
            }
        }

        return label;
    }

    /**
     * Classify a test doc
     *
     * @param doc test doc
     * @return class label
     */

    public void classifyAll(String testDocs) {

        File path = new File(testDocs);
        ArrayList<Integer> testLabel = new ArrayList<Integer>();
        ArrayList<Integer> wTestLabel = new ArrayList<Integer>();
        String[] files = path.list();

        for (int i = 0; i < files.length; i++) {
            System.out.println(path + "/" + files[i]);
            File read = new File(path + "/" + files[i]);
            String[] fileNames = read.list();
            for (int j = 0; j < fileNames.length; j++) {

                try {
                    Scanner scan = new Scanner(new File(read + "/"
                            + fileNames[j]));
                    // System.out.println(read+"/"+fileNames[j]);
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        sb = sb.append(line);
                    }
                    // System.out.println(sb.toString());
                    int label = classfiy(sb.toString());
                    if (label == i) {
                        testLabel.add(label);
                    } else {
                        wTestLabel.add(label);
                    }
                    sb.setLength(0);

                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
        System.out.println("Train data has following \nAttorney: " + classCounts[1] + " Computer: " + classCounts[0] + " MBA:" + classCounts[2] +" Misc:"+classCounts[3]);
        System.out.println("Right: " + testLabel.size() + "\nWrong: " + wTestLabel.size());
        double total = testLabel.size() + wTestLabel.size();
        double right = testLabel.size();
        double accuracy = (right) / total;
        System.out.println("Accuarcy: " + accuracy * 100 + "%");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String trainData = "/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/data/train";
        //StringBuffer sb1 = new StringBuffer();
        NBClassifier nb = new NBClassifier(trainData);
        nb.classifyAll("/Users/karankothari1/GlassFish_Server/glassfish/domains/Resumepedia/data/test");

    }
}
