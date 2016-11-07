package com.mcakir;

import com.mcakir.gcm.GcmService;
import com.mcakir.gcm.MessageContent;
import com.mcakir.gcm.MulticastResult;
import com.mcakir.gcm.Result;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

        System.out.println("[STARTED] Pushing message service");
        System.out.println("---");

        pushToGCM(createMessageContent());

        System.out.println("[FINISHED] Pushing message service");

    }

    private static void pushToGCM(MessageContent content){

        GcmService gcmService = new GcmService();

        MulticastResult response = gcmService.push(content);

        if(response != null){

            int i = 0;

            for(Result result : response.getResults()){

                System.out.println("[VALID] RESULT[" + i + "]: " + result);
                System.out.println("---");

                if(result.getMessageId() == null && result.getError() != null){

                    System.out.println("[INVALID] RESULT[" + i + "]");
                    System.out.println("---");

                }

                // handle other cases

                i++;
            }

        }

    }

    private static MessageContent createMessageContent(){

        List<String> registrationIds = new ArrayList<>();
        registrationIds.add("XYZABCDEFGS");
        registrationIds.add("ABCDEFXYZAS");

        MessageContent content = new MessageContent();
        content.setRegistrationIds(registrationIds);
        content.addData("title", "GCM push test");

        return content;

    }

}
