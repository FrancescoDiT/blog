package polimi.blog.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import polimi.blog.model.Tag;

public class TagParser {
    
    public static List<Tag> parseTags(String input) {
        List<Tag> tags = new ArrayList<>();     
        if (input != null && !input.isEmpty()) {
            String[] tagArray = input.split(",");
            for (String tag : tagArray) {
            	tag.trim();
            	if(tag.contains(" ")) {
            		continue;
            	}else {
                String cleanedTag = tag.replaceAll("\\W", "");                 		
                if (!cleanedTag.isEmpty()) {
                	Tag t = new Tag(cleanedTag);
                    tags.add(t);
                }
            }
        }  
     }
        return tags;
  }
}