import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Iterator;

/**
  *	Class to read the input, execute and print the given commands
  */

public class AsciiShop{

	public static void main(String[] args){

		String create, command, charset;
		boolean halt = false;
		boolean unknownCommand = false;
		boolean centroid = false;
		int width, height = 0;

		Scanner sc = new Scanner(System.in);
		
//		read the input

		create = sc.next();
		width = sc.nextInt();
		height = sc.nextInt();

		charset = "";		

		/*check if there is a charset, else exception*/

		command = sc.next();
		
		if(command.equals("load")){
			throw new IllegalArgumentException("no charset");
		}else if(!create.equals("create") || width <= 0 || height <= 0){
			halt = true;
		}else{
			charset = command;
		}

		if(halt == false){

//			create an image, clear, create stack + factory

			AsciiImage ai = new AsciiImage(width,height,charset);
			ClearOperation c1 = new ClearOperation();
			AsciiImage img = new AsciiImage(ai); 
			img = new AsciiImage(c1.execute(ai));
			AsciiStack stack = new AsciiStack();
			Factory f1;
			MetricSet<AsciiImage> ms = new MetricSet<AsciiImage>();

//			image on the stack

			stack.push(img);

//			fill HashMap
			HashMap<String, Factory> hm = new HashMap<String, Factory>();
			
			hm.put("fill", new FillFactory());
			hm.put("binary", new BinaryFactory());
			hm.put("clear", new ClearFactory());
			hm.put("filter", new FilterFactory());
			hm.put("grow", new GrowRegionFactory());
			hm.put("line", new LineFactory());			
			hm.put("load", new LoadFactory());
			hm.put("replace", new ReplaceFactory());
			hm.put("transpose", new TransposeFactory());
			hm.put("create", new CreateFactory());

//			check command in HashMap
			while(sc.hasNext() && halt == false){

				command = sc.next();

				if(hm.containsKey(command)){
					stack.push(img);
					f1 = hm.get(command);
					try{
						try{
							img = f1.create(sc).execute(img);
						}catch(OperationException e){
							System.out.println("OPERATION FAILED");
							halt = true;
						}
					}catch(FactoryException e){
						System.out.println("INPUT MISMATCH");
						halt = true;
					}
				}else if(command.equals("save")){
					f1 = new SaveFactory(ms);
					try{
						try{
							img = f1.create(sc).execute(img);
						}catch(OperationException e){
							System.out.println("OPERATION FAILED");
							halt = true;
						}
					}catch(FactoryException e){
						System.out.println("INPUT MISMATCH");
						halt = true;
					}
				}else if(command.equals("search")){
					f1 = new SearchFactory(ms);
					try{
						try{
							img = f1.create(sc).execute(img);
						}catch(OperationException e){
							System.out.println("OPERATION FAILED");
							halt = true;
						}
					}catch(FactoryException e){
						System.out.println("INPUT MISMATCH");
						halt = true;
					}
				}else if(command.equals("print")){
					System.out.println(img.toString());
				}else if(command.equals("printsaved")){
					Iterator it = ms.iterator();
					if(it.hasNext() == false){
						System.out.println("NO SAVED IMAGES");
					}else{
						while(it.hasNext()){
							System.out.println(it.next().toString());
						}
					}
				}else if(command.equals("undo")){
					img = new AsciiImage(stack.pop());				

					if(stack.empty()){
						System.out.println("STACK EMPTY");
						halt = true;
					}
				}else if(command.equals("histogram")){

					AsciiImage im = new AsciiImage(img.getCharset().length(),16, img.getCharset());
					Histogram h1 = new Histogram();
					TransposeOperation t1 = new TransposeOperation();

					try{
						img = t1.execute(h1.getHistogram(img));
					}catch(OperationException e){
						System.out.println("OPERATION FAILED");
						halt = true;
					}

//					flip the image upside down
					String newPic = "";
					int a = (img.getHeight() - 1)*img.getWidth();
					int b = img.getHeight()*img.getWidth();
					for(int i = img.getHeight(); i > 0 ; i--){
						newPic += img.picture.substring(a,b);
						a = a - img.getWidth();
						b = b - img.getWidth(); 
					}
					img.picture = newPic;
					System.out.print(img.toString());
				}
			}	
		}
	}
}
