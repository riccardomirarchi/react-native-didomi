
#import "RNDidomi.h"
#import <Didomi/Didomi.h>
//#import <React/RCTLog.h>

@implementation RNDidomi

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(init: (NSString *)apiKey remoteUrl: (NSString *)url)
{
    @try {
    Didomi *didomi = [Didomi shared];
    [didomi setLogLevelWithMinLevel:2];
    [didomi initializeWithApiKey:apiKey
            localConfigurationPath:nil
            remoteConfigurationURL:url
            providerId:nil
            disableDidomiRemoteConfig: (url != nil)
            languageCode:nil];
    }
    @catch(NSException *e) {
        NSLog(@"error initializing the didomi sdk %@", e);
        //RCTLogInfo(@"error initializing the didomi sdk %@", e);
    }
}
RCT_EXPORT_METHOD(showNotice)
{
    @try {
        Didomi *didomi = [Didomi shared];
        [didomi showNotice];
    } @catch (NSException *e) {
        NSLog(@"error showing notice %@", e);
        //RCTLogInfo(@"error showing notice %@", e);
    }

}

RCT_EXPORT_METHOD(hideNotice)
{
    @try {
        Didomi *didomi = [Didomi shared];
        [didomi hideNotice];
    } @catch (NSException *e) {
        NSLog(@"error hiding notice %@", e);
        //RCTLogInfo(@"error hiding notice %@", e);
    }
}

RCT_EXPORT_METHOD(showPreferences)
{
    @try {
        Didomi *didomi = [Didomi shared];
        [didomi showPreferencesWithController:[UIApplication sharedApplication].delegate.window.rootViewController view:ViewsPurposes];
    } @catch (NSException *e) {
        NSLog(@"error showing preferences %@", e);
        //RCTLogInfo(@"error showing preferences %@", e);
    }

}

RCT_EXPORT_METHOD(hidePreferences)
{
    @try {
        Didomi *didomi = [Didomi shared];
        [didomi hidePreferences];
    } @catch (NSException *e) {
        NSLog(@"error hiding preferences %@", e);
        //RCTLogInfo(@"error hiding preferences %@", e);
    }

}

@end
