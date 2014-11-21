# The basics for building with Neura

##Neura distills context. 
###Neura distills raw data from a user's smartphone and internet-of-things (IoT) devices into contextual knowledge so that you can enhance that user's life.

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