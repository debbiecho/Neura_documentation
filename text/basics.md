#An introduction to Neura

##Neura distills context. 
####Neura distills raw data from a user's smartphone and internet-of-things (IoT) devices into contextual knowledge so that you can enhance that user's life.

##The API is in private alpha
The API is currently available only to select developers while it is in alpha.  If you'd like to apply for access, contact us at build [at] theneura [dot] com; please be sure to include information on your technical skills and use cases you'd like to address.  

Particularly because the API is in alpha, we appreciate your patience as we continue to improve it.  We will do our best to give you at least 10-days notice before releasing breaking changes and to constantly communicate the [status of the API](). 

## Neura conventions
**How do dates work? Timezones? Flight/travel?**
   **feedback from Eric @ Zenobase: what timezone? when does date start and end? how do we align different datasets?**
**What is the expected latency on push events?** 
**Even if we don't have perfect answers, let's address upfront.**


##Privacy
Neura puts user privacy first and we expect our community of Builders to do the same.  We've designed Neura to distill data to enrich our users' lives, not to sell ads. If  you have any concerns 

HTTPS is required for all Neura APIs because private user information will be transmitted. Users trust your application with this info and Neura expects you respect this trust. We require that your application not retransmit insecurely, retain indefinitely or share with 3rd parties any data sent via the Neura API. 

### Authentication

You can query the Neura API to pull information about a user. All requests for user data must include an **authorization header** containing the user's access token:

**Example**

```
Authorization: Bearer asdf1234*****************
```

**We need to explain how to get the auth token**