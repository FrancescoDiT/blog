package polimi.blog.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import polimi.blog.model.Tag;

public class TagParser {
    
    public static List<Tag> parseTags(String input) {
        List<Tag> tags = new ArrayList<>();  
        List<String> cleanedTags = new ArrayList<>();
        
        
        if (input != null && !input.isEmpty()) {
            String[] tagArray = input.split(",");
            
            for (String tag : tagArray) {
            	String tagT = tag.trim();
            	
            	if(tagT.contains(" ") || tagT.isEmpty()){
            		continue;
            		
            	}else {
                String cleanedTag = tagT.replaceAll("\\W", "");       
                  
	                if (!cleanedTag.isEmpty()) {
	                	
	                		if(!cleanedTags.contains(cleanedTag)) {
	                			cleanedTags.add(cleanedTag);
	                			Tag t = new Tag(cleanedTag);
	                			tags.add(t);
	                 }
	            }
            }
        }  
     }      
        return tags;
  }
}		                	
