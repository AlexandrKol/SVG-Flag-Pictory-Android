# SVG-Flag-Pictory-Android

## Implementation

add a file libs/flagpictory.aar to the libs/ folder of your project.

add a dependencies line: 

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar', '*.aar'])
          ...
          
 update project 
 
 ## usage
 
 FlagView flv = new FlagView(getApplicationContext());
 
 option 
   flv.setTypePictory("circle");
 or
  flv.setTypePictory("rect");
  flv.setRadiusStroke("20%");
  
   flv.setLoadFlag(Locale.getDefault().getCountry().toLowerCase());
   
   or 
   listcounry - getAliases or getValues
  flv.setLoadFlag(listcounry[variant]);
  
  ### xml
  
  <a.b.svgflagsdrawable.FlagView
        android:layout_width="50dp"
        android:layout_height="50dp"
        app:type_pictory="rect"
        app:Radius_border="20%"
        android:id="@+id/flag"
        />
        
  ## svg
  
  setLoadSVG(file) ;
  setLoadSVG(InputStream) ;
  
  
  
   
  
 
