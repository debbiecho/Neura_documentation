
#Build with Neura 
Neura provides context. We distill raw data into contextual knowledge so that you can make **smarter** apps and internet-of-things (IoT) devices.  

###Neura is ready for you to build awesome apps
You can use the Neura API and SDKs to securely access user data by subscribing to PUSH events or requesting a data object.  User privacy is critical to us, so we ensure that users have approved your access to their data with OAuth2 authentication.

### Get started in minutes
 - [Quickstart: request wellness information for a user](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md) (3-minute project) _100% done!_
 - [Quickstart: subscribe to a push notification for **Android**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md) (5-minute project) _70% done -- mikimer & chiki to get app working again_
 - [Quickstart: authenticate a user as a 3rd party app for **iOS**](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstart_iOS.md) (5-minute project) _90% done -- update with new demo app image_

### Learn more
 - [An introduction to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/basics.md)  _90% done. need to make professional quality diagrams_   
 - [Create a developer account](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/account.md) _30% done - eroc is on it_
 - [Authentication and permissions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/authentication.md) _40% done - mikimer & berman to complete; possibly move to basics.md_
 - [API data objects](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/pull.md) _90% done. a few questions for Berman_  
 - [API event subscriptions](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/push.md)  _50% done. Berman to fill in_ 
 - [SDK for Android](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_Android.md) _80% done. a few things to clarify with chiki_ 
 - [SDK for iOS](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/SDK_iOS.md) _60% done. clarify a few things with Michael_   
 - [Integrated devices that can send data to Neura](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/integrations.md) _100% done!_ 
 - [Current status of the Neura API](https://github.com/NeuraLabs/Neura_documentation/blob/master/text/status.md) _80% done. Mikimer to chat with Triinu & Berman about how to maintain this page_ 

### Questions? Comments? Wanna grab a beer?
Reach out to us at build [at] theneura [dot] com.  We're serious about the :beer:.


----------------

#Internal Neura notes 
Mikimer has moved the API and SDK docs from Word to Github to (1) make it easier to collaborate, (2) improve formatting and readability, and (3) to create an MVP that's ready for public release.

Plans:  
- Mikimer will own this document until further notice
- Anyone else editing the doc will submit change to Mikimer for approval
- Mikimer will flag Issues for team members to address  


The source documents were:  
  - NEURA.ME API Integration Guide ver 2.docx    
  - NEURA.ME Android Integration Guide.docx  
  - NEURA ME iOS Integration Guide.docx

Throughout the document ***I've embedded italics-bold text with questions for whoever wrote the original text***.  I'm planning on sitting down with the tech team to get answers to these questions when I'm in Israel Nov 30th to Dec 12th 2014.  I'd LOVE IT if you forked the original documents and responded to these questions.  Eroc quickly became a master of the fork and pull request, so I'm confident the tech team can do it too, hehe ;)

Conventions:  
- states - instantaneous (1 sec?) moment where Neura returns where the user is / what they're doing PULL **Next step: Berman to chat w/ Ori about distinguishing between States & Events.  As of today, there are no 'States' available in the API -- we developed userIsWalking it's disabled until further notice.**
- events - change in state PUSH
- data objects - dataset for the user during a period of time PULL. **Mike to talk w/ Gilad & Ori**

Big To Do's
- Get Android sample app working. https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPull.md#examine-your-own-daily_summary-data
- Go through PUSH subscription & document https://github.com/NeuraLabs/Neura_documentation/blob/master/text/quickstartPush.md 
- Go through time & timezones in Neura. Document edge cases.  


###delete internal notes before public release


