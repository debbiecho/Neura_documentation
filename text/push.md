
##Subscribing to PUSH notifications for events

`POST https://wapi.theneura.com/v1/subscriptions`
PARAMETERS	`name`	The specific events names are listed and described in developer console dev.theneura.comchange_parameter	Behavioral change parameter in percent. Default value is 10%. It is applied only per specific services when service requires it.Not supported yetoccur_parameter	Applied specifically per services that identify an event will happen in certain minutes. The parameter defines the number of minutes. Default value is 10 minutes.Not supported yetmethod	Optional parameter. Specify the method how the event should be notified. Possible values “all”, “push”, “webhook”. Default value is “all”.webhook_id	Optional parameter. Identifies the webhook to which to notify the events. Default value is the default application subscriber url that was defined in the application registration process. subscription_id	Required. Customer’s subscription identifier for tracking the subscription notification event. state	Optional. Customer’s can set it. It is always included into subscribed notification event.




